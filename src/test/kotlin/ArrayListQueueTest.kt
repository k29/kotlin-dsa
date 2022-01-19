import kotlin.test.Test
import kotlin.test.assertEquals

internal class ArrayListQueueTest {
    private val testArrayListQueue:ArrayListQueue<String> = ArrayListQueue<String>()

    @Test
    fun testEnqueue() {
        testArrayListQueue.enqueue("java")
        assertEquals("java", testArrayListQueue.peek())
    }

    @Test
    fun testDequeue() {
        testArrayListQueue.enqueue("java")
        testArrayListQueue.enqueue("python")
        testArrayListQueue.dequeue()
        assertEquals("python", testArrayListQueue.peek())
    }
}