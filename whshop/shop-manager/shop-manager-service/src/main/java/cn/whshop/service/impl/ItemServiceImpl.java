package cn.whshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.whshop.mapper.TbItemMapper;
import cn.whshop.pojo.TbItem;
import cn.whshop.pojo.TbItemExample;
import cn.whshop.pojo.TbItemExample.Criteria;
import cn.whshop.service.ItemService;

/**
 * 商品管理service
 * @author haohao
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private  TbItemMapper tbItemMapper;
	
	@Override
	public TbItem getItemById(Long itemid) {
		//根据主键查询
		//TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemid);
		//设置查询条件
		TbItemExample example = new TbItemExample();
		Criteria createCriteria = example.createCriteria();
		//设置查询条件
		createCriteria.andIdEqualTo(itemid);
		
		List<TbItem> tbItemList = tbItemMapper.selectByExample(example);
		
		if (tbItemList != null && tbItemList.size() > 0) {
			return tbItemList.get(0);
		}
		return null;
	}

}
