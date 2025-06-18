# Checkstyle Experiment

A Spring Boot project to experiment with [Checkstyle](https://checkstyle.org/) integration and enforce Java coding
standards automatically during the build process. This setup helps developers maintain clean, consistent, and readable
code by catching formatting and style violations early.

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

## 🔨 Build with Checkstyle

```bash
docker build -t checkstyle-experiment .
```

* ✅ If all rules pass, it builds the JAR.
* ❌ If any style violation is found, the build will fail and show details.

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

