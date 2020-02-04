dubbo-boot是基于spring boot 和dubbo服务框架构建的，项目采用Maven分模块构建，其示例取之于springside,目前代码还比较简单，仅仅把二者加以整合，接下来想把rop框架引入，做一套开放网关服务(https://github.com/itstamen/rop)    

RoadMap  

最近准备完善该项目，扩展dubbo，实现对服务的编排
系统设计框架图
![image](https://raw.githubusercontent.com/goodluckwgw/dubbo-boot/master/image/%E7%BB%98%E5%9B%BE1.jpg)

网关: 负责前端请求接收并转发到相应的业务层主控层  

主控层 : 接口服务主控层是有各原子服务串织成的, 接口服务主控层通过Dubbo方式调用接入接出模块，负责整个产品的业务逻辑，在业务层中没有具体的操作，只有业务调用.  

zookeepr： dubbo服务注册中心，通过zookeeper 注册的原子服务，主控层可调用业务需要的所有服务.  

原子服务 ：原子服务层，只提供单一的服务，并注册到zookeeper以供主控层层调用

近期准备实现dubbo服务的编排层，有兴趣的可以加QQ交流群: 461622009(另提供开相关dubbo技术文档/视频下载)


