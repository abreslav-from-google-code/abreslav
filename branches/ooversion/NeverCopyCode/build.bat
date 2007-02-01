for %%1 IN (*.dpr) do dcc32 -Ebin %%1
for %%1 IN (nccwin\*.dpr) do dcc32 %%1

pause