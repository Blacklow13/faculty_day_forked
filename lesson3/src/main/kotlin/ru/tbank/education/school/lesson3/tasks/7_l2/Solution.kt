open class HomeworkSubmission(
    val studentName: String,
    var content: String
) {
}

open class ResubmitedHomework : HomeworkSubmission{
    // Считаем, что работу можно отправлять заново: новая версия заменяет старую
    open fun resubmit(newContent: String) {
        content = newContent
        println("Ученик $studentName отправил новую версию работы")
    }
}

class FinalExamSubmission(
    studentName: String,
    content: String
) : HomeworkSubmission(studentName, content) {

}