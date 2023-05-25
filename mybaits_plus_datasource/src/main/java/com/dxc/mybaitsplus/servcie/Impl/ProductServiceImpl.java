package com.dxc.mybaitsplus.servcie.Impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dxc.mybaitsplus.mapper.ProductMapper;
import com.dxc.mybaitsplus.pojo.Product;
import com.dxc.mybaitsplus.servcie.ProductService;
import org.springframework.stereotype.Service;

@Service
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
