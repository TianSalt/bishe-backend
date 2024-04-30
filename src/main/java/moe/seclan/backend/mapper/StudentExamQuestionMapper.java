package moe.seclan.backend.mapper;

import moe.seclan.backend.pojo.Question;
import moe.seclan.backend.pojo.StudentExamQuestion;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface StudentExamQuestionMapper {

    List<StudentExamQuestion> get(Integer studentId, Integer examId, Integer questionIndex);

    void update(StudentExamQuestion studentExamQuestion);

    @Select("""
            SELECT SUM(score) FROM student_exam_question
            WHERE student_uid = #{studentId} AND exam_id = #{examId}""")
    BigDecimal sumScore(Integer studentUid, Integer examId);

    @Insert("""
            INSERT INTO student_exam_question (student_uid, exam_id, question_index, answer)
            VALUES (#{studentUid}, #{examId}, #{questionIndex}, #{answer})
            """)
    void insert(StudentExamQuestion studentExamQuestion);

    @Delete("""
            DELETE FROM student_exam_question
            WHERE student_uid = #{studentId}
                AND exam_id = #{examId}
                AND question_index = #{questionIndex}""")
    void delete(Integer studentUid, Integer examId, Integer questionIndex);

    @Select("""
            SELECT q.*
            FROM question q
            WHERE q.question_id = (
                SELECT eq.question_id
                FROM exam_question eq
                WHERE eq.exam_id = #{examId} AND eq.question_index = #{questionIndex})""")
    Question getQuestion(StudentExamQuestion studentExamQuestion);

    @Select("""
            SELECT score FROM exam_question
            WHERE exam_id = #{examId} and question_index = #{questionIndex}""")
    BigDecimal getScore(StudentExamQuestion studentExamQuestion);

}
