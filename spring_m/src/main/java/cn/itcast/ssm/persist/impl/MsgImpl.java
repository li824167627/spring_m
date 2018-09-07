package cn.itcast.ssm.persist.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.itcast.ssm.model.MessageBean;
import cn.itcast.ssm.persist.dao.MsgDao;

@Repository
public class MsgImpl extends BaseImpl implements MsgDao {

	final String NAME_SPACE = NAME_SPACE_HEADER + ".MsgMapper";

	@Override
	public int insert(MessageBean msg) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", msg);
	}

	@Override
	public int selecMsgs2UserCount(String uid, int type, int loginPort) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tuid", uid);
		params.put("type", type);
		params.put("loginPort", loginPort);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selecMsgs2UserCount", params);
	}

	@Override
	public List<MessageBean> selectMsgs2UserList(String uid, int type, int page, int pageSize, int loginPort) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tuid", uid);
		params.put("type", type);
		params.put("loginPort", loginPort);
		params.put("start", page * pageSize);
		params.put("length", pageSize);
		return sqlSessionTemplate.selectList(NAME_SPACE + ".selectMsgs2UserList", params);
	}

	@Override
	public MessageBean selectOneById(int mid) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectOneById", mid);
	}

	@Override
	public int updateIsRead(MessageBean msg) {
		return sqlSessionTemplate.update(NAME_SPACE + ".updateIsRead", msg);
	}

	@Override
	public int selectUnReadCout(String uid, int type) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tuid", uid);
		params.put("type", type);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectUnReadCout", params);
	}

	@Override
	public int updateIsRead2Type(String uid, int type) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tuid", uid);
		params.put("type", type);
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".updateIsRead2Type", params);
	}

	@Override
	public int insertBatch(List<MessageBean> list) {
		Map<String, Object> where = new HashMap<>();
		where.put("beans", list);
		return sqlSessionTemplate.insert(NAME_SPACE + ".insertBatch", where);
	}

}
