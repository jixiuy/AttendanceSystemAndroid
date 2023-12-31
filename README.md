# AttendanceSystemAndroid 科协签到系统安卓端

## MVVM标准包结构示例：
- app
  - data
    - model
      - User.kt
    - repository
      - UserRepository.kt
    - remote
      - ApiService.kt
    - local
      - UserDao.kt
      - Database.kt
  - ui
    - activities
      - MainActivity.kt
    - fragments
      - home
        - HomeFragment.kt
      - sort
        - SortFragment.kt
      - record
        - RecordFragment.kt
      - mine
        - MineFragment.kt
  - utils
    - NetworkUtils.kt
    - DateUtils.kt
  - App.kt

- data目录包含与数据相关的类，如数据模型（model），数据仓库（repository），远程数据访问（remote）和本地数据访问（local）。
- ui目录包含用户界面相关的类，如活动（activities），适配器（adapters）和视图模型（viewmodels）。
- utils目录包含通用的实用工具类，如网络工具（NetworkUtils）和日期工具（DateUtils）。
- App.kt是应用程序的入口点。

## 功能对标网页版：
- Home：首页签到界面
- Sort：排名界面（老人和新人）
- Record：可以切换学期展示
- Mine：网页版的关于“功能”，主题色切换功能
