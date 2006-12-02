cd full
set ddd=..\..\..\..\..\DelphiGraph
for %%1 IN (*.dpr) do dcc32 -I%ddd% -U%ddd% %%1