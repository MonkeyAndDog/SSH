# SSH

## SSH整合学习项目  
---
1. Spring和Hibernate整合
    1. 在使用了Transaction情况下session使用getCurrentSession获取时，不需要begin和commit
    2. 如果报如下异常，检查是否在sessionFactory中配置了  current_session_context_class
    ```
    Could not obtain transaction-synchronized Session for current thread
    ```
    

