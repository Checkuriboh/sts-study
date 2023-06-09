package com.co.kr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.kr.domain.BoardContentDomain;
import com.co.kr.domain.BoardListDomain;
import com.co.kr.domain.LogDomain;
import com.co.kr.mapper.LogMapper;

@Service
public class LogServiceImple implements LogService {
	
	@Autowired
	private LogMapper logMapper;
	
	@Override
	public List<LogDomain> logAllList(Map<String, Object> map)
	{ return logMapper.logAllList(map); }

	@Override
	public List<LogDomain> logOwnList(Map<String, Object> map)
	{ return logMapper.logOwnList(map); }
	
	@Override
	public int logGetAll()
	{ return logMapper.logGetAll(); }
	
	@Override
	public void logCreate(String crud, BoardContentDomain boardContentDomain)
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bdSeq", boardContentDomain.getBdSeq());
		map.put("mbId", boardContentDomain.getMbId());
		map.put("bdTitle", boardContentDomain.getBdTitle());
		map.put("logCrud", crud);
		
		logMapper.logUpload(map);
	}
}
