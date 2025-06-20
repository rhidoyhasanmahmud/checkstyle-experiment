# 🧪 Checkstyle Experiment with Spring Boot

[![Build with Maven](https://img.shields.io/badge/build-Maven-blue.svg)](https://maven.apache.org/)
[![Code Style: Checkstyle](https://img.shields.io/badge/code%20style-checkstyle-brightgreen.svg)](https://checkstyle.org/)
[![Java](https://img.shields.io/badge/java-21-blue.svg)](https://openjdk.org/projects/jdk/21/)

A Spring Boot project to experiment with [Checkstyle](https://checkstyle.org/) and enforce Java coding standards automatically.  
The project demonstrates how to break — and enforce — Java style rules using a strict custom configuration during Maven builds or Docker builds.

---

## 🧪 Features

- ✅ Enforces code style rules via `checkstyle.xml`
- ✅ Fails build on style violations (strict mode)
- ✅ Dockerized build for isolated testing
- ✅ Demonstrates both bad and good coding practices
- ✅ Ready-to-extend for CI/CD integration

---

## 📁 Project Structure

```plaintext
.
├── src/
│   └── main/java/com/codemechanix/checkstyle_experiment/
│       ├── CodeStyleViolationExample.java     # Intentionally bad code for testing
│       └── CheckstyleExperimentApplication.java
├── checkstyle.xml                             # Custom Checkstyle rules
├── pom.xml                                    # Maven build config with plugin
└── Dockerfile                                 # Docker build that runs Checkstyle
```
---
## 🔨 Build with Checkstyle

```bash
docker build -t checkstyle-experiment .
```

* ✅ If all rules pass, it builds the JAR.
* ❌ If any style violation is found, the build will fail and show details.
---
## 📦 Branches

This project includes both Maven and Gradle based implementations:

- 🧰 **Maven Implementation** – Available on the [`main` branch](https://github.com/rhidoyhasanmahmud/checkstyle-experiment/tree/main)
- ⚙️ **Gradle Implementation** – Available on the [`feature/checkstyle-with-gradle` branch](https://github.com/rhidoyhasanmahmud/checkstyle-experiment/tree/feature/checkstyle-with-gradle)

> You can switch between these branches to explore how Checkstyle is configured and enforced in each build tool.
---

## 📏 [Checkstyle Rules](https://checkstyle.org/checks.html)

> General Rules

| Rule               | Description                                                                 |
|--------------------|-----------------------------------------------------------------------------|
| `LineLength`       | Maximum line length is **120 characters**.                                  |
| `NewlineAtEndOfFile` | Ensures every file ends with a **newline**.                                 |
| `FileTabCharacter` | Disallows the use of **tab characters**. Only spaces are allowed.           |
| `RegexpSingleline` | Detects usage of `print` or `println` and prompts to use a **logger instead**. |

> Naming Conventions

| Rule                | Description                                                                 |
|---------------------|-----------------------------------------------------------------------------|
| `TypeName`          | Class names must follow **PascalCase** (`MyClass`).                         |
| `MethodName`        | Method names must follow **camelCase** (`myMethod`).                        |
| `LocalVariableName` | Local variable names must be in **camelCase**.                              |
| `MemberName`        | Member variable names must be in **camelCase**.                             |
| `ParameterName`     | Method parameters must be in **camelCase**.                                 |


> Import Rules

| Rule              | Description                                                                 |
|-------------------|-----------------------------------------------------------------------------|
| `AvoidStarImport` | Disallows `import java.util.*`. Use explicit imports.                       |
| `UnusedImports`   | Detects and removes unused imports.                                         |

> Code Formatting & Structure

| Rule                 | Description                                                                 |
|----------------------|-----------------------------------------------------------------------------|
| `WhitespaceAround`   | Enforces proper spacing around operators and braces.                        |
| `EmptyLineSeparator` | Ensures blank lines between class, method, and constructor declarations.    |
| `Indentation`        | Enforces **4-space** indentation.                                           |

> Best Practices

| Rule              | Description                                                                 |
|-------------------|-----------------------------------------------------------------------------|
| `NeedBraces`      | Enforces braces `{}` for `if`, `else`, `for`, `while`, and `do` blocks.     |
| `EmptyBlock`      | Disallows empty code blocks `{ }`.                                          |
| `FinalParameters` | Method parameters must be declared as `final`.                              |

> Complexity & Maintainability

| Rule                    | Description                                                                 |
|-------------------------|-----------------------------------------------------------------------------|
| `ParameterNumber`       | Maximum **5 parameters** per method.                                       |
| `MethodLength`          | Maximum **20 lines** per method.                                           |
| `ClassFanOutComplexity` | A class may depend on **up to 20 other classes**.                          |
| `CyclomaticComplexity`  | Limit cyclomatic complexity to **10 per method**.                          |
| `MagicNumber`           | Disallows "magic numbers" (except `-1`, `0`, `1`). Use constants instead.  |

---

## 📦 Sample Checkstyle Output

When you run the project or build the Docker image, Checkstyle will automatically audit your code. If there are any
violations (as in the intentionally bad class), the output will look like this:

```text
14.23 [INFO] Starting audit...
14.23 [ERROR] /app/src/main/java/com/codemechanix/checkstyle_experiment/CodeStyleViolationExample.java:1: File does not end with a newline. [NewlineAtEndOfFile]
14.23 [ERROR] /app/src/main/java/com/codemechanix/checkstyle_experiment/CodeStyleViolationExample.java:3:17: Using the '.*' form of import should be avoided - java.util.*. [AvoidStarImport]
14.23 [ERROR] /app/src/main/java/com/codemechanix/checkstyle_experiment/CodeStyleViolationExample.java:4:15: Unused import - java.lang.System.out. [UnusedImports]
14.23 [ERROR] /app/src/main/java/com/codemechanix/checkstyle_experiment/CodeStyleViolationExample.java:8:17: More than 5 parameters (found 6). [ParameterNumber]
14.23 [ERROR] /app/src/main/java/com/codemechanix/checkstyle_experiment/CodeStyleViolationExample.java:8:17: Name 'BADMethod' must match pattern '^[a-z][a-zA-Z0-9]*$'. [MethodName]
14.23 [ERROR] /app/src/main/java/com/codemechanix/checkstyle_experiment/CodeStyleViolationExample.java:9:13: Name 'SUM' must match pattern '^[a-z][a-zA-Z0-9]*$'. [LocalVariableName]
14.23 [ERROR] /app/src/main/java/com/codemechanix/checkstyle_experiment/CodeStyleViolationExample.java:10: Avoid using print/println, Use a logger instead! [RegexpSingleline]
...
14.23 [ERROR] /app/src/main/java/com/codemechanix/checkstyle_experiment/CheckstyleExperimentApplication.java:9:1: File contains tab characters (this is the first instance). [FileTabCharacter]
14.23 [ERROR] /app/src/main/java/com/codemechanix/checkstyle_experiment/CheckstyleExperimentApplication.java:9:33: Parameter args should be final. [FinalParameters]
14.23 Audit done.
```
---

## 👨‍💻 Author

**Hasan Mahmud Rhidoy**  
**Crafting Cutting-Edge Solutions with Code Wizardry | Driving Innovation in Fintech Solutions**
