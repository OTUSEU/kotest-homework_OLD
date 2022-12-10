import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals

class HomeworkTest : FunSpec({

    context("Test context") {

        test("Addition and multiply") {

            assertEquals(4, multiply(2, 2))
            assertEquals(2, addition(2, 2))
        }
    }

})
