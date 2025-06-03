# 美食地图 后端 - DeliciousFoodMap-Admin

[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/yourusername/gourmet-guide/blob/main/LICENSE)
[![SpringBoot](https://img.shields.io/badge/SpringBoot-3.4.1%2B-brightgreen)](https://spring.io/projects/spring-boot)
[![Vue3](https://img.shields.io/badge/Vue-3.x-brightgreen)](https://vuejs.org/)

基于JDK21 + SpringBoot + MybatisPlus实现的美食地理信息系统，帮助用户发现身边的美食店铺并提供导航服务。

- 美食地图 后端仓库地址 [https://github.com/dhbxs/DeliciousFoodMap-Admin](https://github.com/dhbxs/DeliciousFoodMap-Admin)
- 美食地图 前端仓库地址 [https://github.com/dhbxs/DeliciousFoodMap-Web](https://github.com/dhbxs/DeliciousFoodMap-Web)

## 📌 功能特性

### 用户端功能
- 🗺️ 交互式地图展示
   - [x] 可视化标记所有美食店铺位置
   - [x] 地图缩放/平移/定位操作
- 🔍 智能搜索
   - [x] 按店铺名称/菜系 搜索
- 📍 店铺详情
   - [x] 展示店铺基本信息（地址、菜系）
   - [x] 一键导航（支持高德）
- 🧑 用户系统
   - [ ] 邮箱注册登录
   - [ ] 评论与评分历史

### 管理端功能
- 🛠️ 店铺信息管理
  - [ ] 用户增加/删除店铺

## 🛠️ 技术栈

### 后端服务
- **核心框架**: SpringBoot 3.4+
- **ORM框架**: MybatisPlus 3.5.9
- **API文档**: ApiFox
- **地图服务**: 高德地图API
- **其他组件**: Lombok、JWT

### 前端应用
- **核心框架**: Vue3 + JavaScript
- **地图组件**: AMap JS API

### 数据存储
- **主数据库**: MySQL 8.0+

## 🚀 快速开始

### 环境要求
- JDK 21+
- MySQL 8.0+
- Maven 3.9+

### 后端部署
1. 克隆仓库：
```bash
git clone https://github.com/dhbxs/DeliciousFoodMap.git
```

2. 创建数据库并导入项目sql文件夹内的sql脚本

3. 修改配置文件 `src/main/resources/application.yml`：
```yaml
datasource:
  url: jdbc:mysql://localhost:3306/gourmet_db
  username: your_username
  password: your_password
```

4. 启动应用：
```bash
mvn spring-boot:run
```

5. 后端接口文档： 通过 Apifox 共享
 [https://hdfjk079cx.apifox.cn](https://hdfjk079cx.apifox.cn)


### 前端参考页面
- 由 Fluid 社群 民事纠纷处理师兼职情感咨询师 大佬提供 [https://map.javai.cn/](https://map.javai.cn/)

## 🤝 贡献指南
欢迎通过以下方式参与项目：
1. Fork项目仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交修改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送分支 (`git push origin feature/AmazingFeature`)
5. 发起Pull Request

## 📄 许可证
本项目采用 [MIT License](LICENSE)

## 🙏 致谢
- Fluid 社群
- Spring Boot开源社区

---

> 🌟 如果这个项目对您有帮助，欢迎给个Star支持！您的认可是我们持续改进的动力！