for /D %%1 IN (*) do del %%1\*.dpr
for /D %%1 IN (*) do del %%1\*.dof
for /D %%1 IN (*) do del %%1\*.cfg
for /D %%1 IN (*) do ..\..\upx.exe -9 %%1\*.exe
for /D %%1 IN (*) do "C:\Program Files\7-Zip\7z.exe" a -r -tzip %%1.zip %%1
pause