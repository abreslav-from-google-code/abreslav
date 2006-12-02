rd /s /q tasks
md tasks
copy full\*.exe tasks
for %%1 IN (tasks\*.exe) do ..\upx -9 %%1