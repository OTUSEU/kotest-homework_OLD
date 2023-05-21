import io.kotest.core.extensions.TestCaseExtension
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult


class RepeatOnFailureExtension : TestCaseExtension {
    private val maxRepeat = 5
    private var attempt = 1


    override suspend fun intercept(testCase: TestCase, execute: suspend (TestCase) -> TestResult): TestResult {
        val result = execute(testCase)

        if (result.isErrorOrFailure && maxRepeat > attempt){
            attempt++
            intercept(testCase, execute)
            return result
        }

        return result
    }

}