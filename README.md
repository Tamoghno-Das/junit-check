🧪 JUnit 5 Testing — Method Ordering & Parameterized Tests
----------------------------
⚙️ Test Method Ordering

JUnit 5 allows you to define the order in which test methods are executed using the @TestMethodOrder annotation at the class level.

Available Method Orderers

| Orderer Type                        | Description                                                                             |
| ----------------------------------- | --------------------------------------------------------------------------------------- |
| **`MethodOrderer.Alphanumeric`**    | Executes test methods **in alphabetical (lexicographic)** order by their names.         |
| **`MethodOrderer.OrderAnnotation`** | Executes test methods **based on the `@Order` annotation** value assigned to each test. |
| **`MethodOrderer.Random`**          | Executes test methods **in random order** each time.                                    |
| **`MethodOrderer.DisplayName`**     | Executes test methods **in order of their display names** (defined via `@DisplayName`). |


🧩 Parameterized Tests
Overview

Parameterized Tests in JUnit 5 allow a single test method to be executed multiple times with different parameters or arguments.
This helps in testing various input scenarios without duplicating test code.

Key Points

Eliminates repetitive test methods for multiple input cases.

Requires the following dependency:
```
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>5.x.x</version>
    <scope>test</scope>
</dependency>
```

Annotation used:
```@ParameterizedTest```


🧱 Supported Parameter Sources
----------------------------------


| Annotation           | Description                                                                                                    | Example Usage                                                 |
| -------------------- | -------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------- |
| **`@ValueSource`**   | Supplies a single array of literal values (e.g., `int`, `long`, `boolean`, `String`, etc.) to the test method. | `@ValueSource(ints = {1, 2, 3, 4, 5})`                        |
| **`@EnumSource`**    | Provides **enum constants** as parameters to the test method.                                                  | `@EnumSource(MyEnum.class)`                                   |
| **`@CsvSource`**     | Supplies **comma-separated values** directly within the test class.                                            | `@CsvSource({"0,1", "1,1", "2,2", "3,6", "4,24", "5,120"})`   |
| **`@CsvFileSource`** | Loads test data from an **external CSV file** and feeds it to the test method.                                 | `@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)` |


Example — Using @CsvSource

```java
@ParameterizedTest
@CsvSource({
    "0, 1",
    "1, 1",
    "2, 2",
    "3, 6",
    "4, 24",
    "5, 120"
})
void testFactorial(int input, int expected) {
    assertEquals(expected, MathUtils.factorial(input));
}
```

Example — Using @ValueSource

```java
@ParameterizedTest
@ValueSource(strings = {"Hello", "JUnit", "Test"})
void testNonEmptyString(String input) {
    assertFalse(input.isEmpty());
}
```

✅ In Summary:

@TestMethodOrder → Controls the execution order of tests.

@ParameterizedTest → Reuses the same test logic with different inputs.

Supported sources include @ValueSource, @EnumSource, @CsvSource, and @CsvFileSource.



