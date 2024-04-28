package moe.seclan.backend.mapper;

import moe.seclan.backend.pojo.StudentExam;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentExamMapper {

    @Select("SELECT * FROM student_exam WHERE student_uid = #{studentUid} AND exam_id = #{examId}")
    Boolean getPresence(Integer student_uid, Integer exam_uid);

    @Insert("""
            INSERT INTO student_exam(student_uid, exam_id) 
            VALUES (#{studentUid}, #{examId})""")
    void insert(StudentExam studentExam);

    @Update("""
            UPDATE student_exam SET presence = TRUE
            WHERE student_uid = #{studentUid} AND exam_id = #{examId} """)
    void present(StudentExam studentExam);

    @Delete("DELETE FROM student_exam WHERE student_uid = #{studentUid} AND exam_id = #{examId}")
    void delete(Integer studentUid, Integer examId);

}