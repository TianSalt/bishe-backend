package moe.seclan.backend.mapper;

import moe.seclan.backend.pojo.Exam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ExamMapper {


    List<Exam> get(Integer examId, Integer creator, Boolean isPublished,
                   String examName, LocalDateTime fromTime, LocalDateTime toTime);

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
        introduction
    )
    VALUES (
        #{creator},
        #{isPublished},
        #{examName},
        #{startTime},
        #{endTime},
        #{introduction}
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
            introduction = #{introduction}
        WHERE exam_id = #{examId}
        """)
    void update(Exam exam);

}
