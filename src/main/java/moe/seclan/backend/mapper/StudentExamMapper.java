package moe.seclan.backend.mapper;

import moe.seclan.backend.pojo.Exam;
import moe.seclan.backend.pojo.Student;
import moe.seclan.backend.pojo.StudentExam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentExamMapper {

    List<StudentExam> get(Integer studentUid, Integer examId, Boolean presence);

    @Select("""
            SELECT s.*
            FROM student s
            WHERE s.uid IN (
                SELECT se.student_uid
                FROM student_exam se
                WHERE se.exam_id = #{examId}
            );""")
    List<Student> getStudentsInExam(Integer examId);

    @Select("SELECT presence FROM student_exam WHERE student_uid = #{studentUid} AND exam_id = #{examId}")
    Boolean getPresence(Integer student_uid, Integer exam_uid);

    @Select("""
            SELECT e.*
            FROM exam e
            WHERE e.is_published = true and e.exam_id IN (
                SELECT se.exam_id
                FROM student_exam se
                WHERE se.student_uid = #{studentUid}
            );""")
    List<Exam> getExamsOfStudent(Integer studentUid);

    @Insert("""
            INSERT INTO student_exam(student_uid, exam_id)
            VALUES (#{studentUid}, #{examId})""")
    void insert(StudentExam studentExam);

    @Update("""
            UPDATE student_exam SET presence = TRUE
            WHERE student_uid = #{studentUid} AND exam_id = #{examId}""")
    void present(StudentExam studentExam);

    @Delete("DELETE FROM student_exam WHERE student_uid = #{studentUid} AND exam_id = #{examId}")
    void delete(Integer studentUid, Integer examId);

}
