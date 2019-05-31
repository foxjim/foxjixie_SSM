package org.hnist.service;

import javax.annotation.Resource;

import org.hnist.mapper.NewsContentMapper;
import org.hnist.mapper.NewsHeadMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 新闻的Service实现类
 * @author Liuyun 2019/05/31
 *
 */
@Service("NewsService")
@Transactional
public class NewsServiceImpl implements NewsService{
	
	@Resource
	private NewsContentMapper newsContentMapper;
	@Resource
	private NewsHeadMapper newsHeadMapper;
	
	
}
