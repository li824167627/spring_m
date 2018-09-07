package cn.itcast.ssm.persist.dao;

import java.util.List;

import cn.itcast.ssm.model.MessageBean;

public interface MsgDao {

	/**
	 * 插入新消息
	 * 
	 * @param msg
	 * @return
	 */
	int insert(MessageBean msg);

	int selecMsgs2UserCount(String uid, int type, int i);

	List<MessageBean> selectMsgs2UserList(String uid, int type, int page, int pageSize, int i);

	MessageBean selectOneById(int mid);

	int updateIsRead(MessageBean msg);

	int selectUnReadCout(String uid, int type);

	int updateIsRead2Type(String uid, int type);

	int insertBatch(List<MessageBean> msgs);

}
