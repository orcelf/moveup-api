package jp.co.vermore.mapper;

import jp.co.vermore.entity.BatchStatus;

import java.util.List;

public interface BatchStatusMapper {

    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table batch_status
     *
     * @mbggenerated Wed Jun 13 13:05:39 CST 2018
     */
    Long insert(BatchStatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table batch_status
     *
     * @mbggenerated Wed Jun 13 13:05:39 CST 2018
     */
    int insertSelective(BatchStatus record);

    BatchStatus selectByPrimaryKey(Integer id);

    List<BatchStatus> getBatchStatus(Byte batchType, Byte status);

    int updateByPrimaryKeySelective(BatchStatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table batch_status
     *
     * @mbggenerated Wed Jun 13 13:05:39 CST 2018
     */
    int updateByPrimaryKey(BatchStatus record);
}