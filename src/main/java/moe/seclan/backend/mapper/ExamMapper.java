package moe.seclan.backend.mapper;

import moe.seclan.backend.pojo.Exam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExamMapper {

    @Select("SELECT * FROM exam")
    List<Exam> getAll();

//    @Select("SELECT * FROM exam WHERE creator = #{teacherUid}")
//    List<Exam> getByTeacherUid(Integer teacherUid);

    @Delete("DELETE FROM exam WHERE exam_id = #{examId}")
    void delete(Integer examId);


    @Insert("""
    INSERT INTO exam (
        creator,
        is_published,
        exam_name,
        start_time,
        end_time,
        is_encrypted,
        password_hash,
        introduction,
        comment
    )
    VALUES (
        #{creator},
        #{isPublished},
        #{examName},
        #{startTime},
        #{endTime},
        #{isEncrypted},
        #{passwordHash},
        #{introduction},
        #{comment}
    )
""")
    void insert(Exam exam);



    @Update("""
        UPDATE exam
        SET creator = #{creator},
            is_published = #{isPublished},
            exam_name = #{examName},
            start_time = #{tartTime},
            end_time = #{endTime},
            is_encrypted = #{isEncrypted},
            password_hash = #{passwordHash},
            introduction = #{introduction},
            comment = #{comment}
        WHERE exam_id = #{examId}
        """)
    void update(Integer examId, Exam exam);

}
