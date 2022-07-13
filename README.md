# AndroidBaseProject-MVVM

1. git clone --depth 1 https://gitlab.com/giboxdev/baseprojectmvvm-android.git --origin BaseProjectMVVM-Android  [NEW-PROJECT-NAME]
2. cd [NEW-PROJECT-NAME] 
3. create new repo 
4. git remote add origin https://[USERNAME-GITLAB]@gitlab.com/giboxdev/NEW-PROJECT-GITLAB-ACCOUNT]/[NEW-REPO-NAME].git 
5. git fetch --unshallow 
6. git add . 
7. git branch -M main
8. git push -uf origin main
--------------------------
9. open the new project in android studio
10. Rename package under app/src/main/java. 
11. Update APPLICATION_ID in app/build.gradle. 
12. Rename Root folder project in settings.gradle -> rootProject.name = "[Your-Name-Project]"
13. Rename package name in Manifest. 
14. Rename Signature Copyright project in File -> Settings -> Copyright -> Copyright Profiles -> Change to name you 

#Sample signature copyright
```
Created by [Your-Name]
, $today.day/$today.month/$today.year
Copyright (c) $today.year by Gibox Digital Asia.
All Rights Reserve
```

15. git add . 
16. git commit -m "refactoring package name
17. git push -u origin main 
18. Remove README.MD.
