package moe.seclan.backend.mapper;

import moe.seclan.backend.pojo.ExamQuestion;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ExamQuestionMapper {

    @Insert("""
            INSERT INTO exam_question(question_index, exam_id, question_id, score)
            VALUES (#{questionIndex}, #{examId}, #{questionId}, #{score})""")
    void insert(ExamQuestion examQuestion);

    @Update("""
            UPDATE exam_question
            SET question_id = #{questionId}, score = #{score}
            WHERE exam_id = #{examId} AND question_index = #{questionIndex}""")
    void update(ExamQuestion examQuestion);

    void delete(Integer examId, Integer questionIndex);

    List<ExamQuestion> get(Integer examId, Integer questionIndex);
}
