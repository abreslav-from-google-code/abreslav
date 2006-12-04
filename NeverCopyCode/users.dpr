program users;
{$APPTYPE CONSOLE}

uses
  SysUtils,
  Math,
  Classes,
  DataCommons in 'DataCommons.pas',
  UsersUnit in 'UsersUnit.pas';

procedure ShowUsage;
begin
  WriteLn('Finds similarity metric of two byte files');
  WriteLn('Usage:');
  WriteLn('users <option> <user_name> [<new_name>]');
  WriteLn('Options:');
  WriteLn('  -add - add a user');
  WriteLn('  -ren - rename a user (to a <new_name>)');
  Halt(0);
end;

var
  mode : (modeAdd, modeRen);
  name : String;
  newName : String;
  uf : TUserFile;
  size : Integer;
  dest, rep : Integer;
begin
  if ParamCount < 2 then
    ShowUsage;

  if ParamStr(1) = '-add' then
    mode := modeAdd
  else if ParamStr(1) = '-ren' then begin
    mode := modeRen;
    if ParamCount < 3 then
      ShowUsage;
    newName := ParamStr(3);
  end else begin
    WriteLn('Unknown mode: ', ParamStr(1));
    Exit;
  end;

  name := ParamStr(2);

  try
    uf := TUserFile.Create(USERS_FILE);

    case mode of
      modeAdd: begin
        size := uf.Size;
        if uf.AddUser(name) >= size then
          WriteLn('User added successfully')
        else WriteLn('User name already exists');
      end;
      modeRen: begin
        dest := uf.IndexOf(name);
        if dest < 0 then begin
          WriteLn('User does not exist: ', name);
        end else begin
          rep := uf.IndexOf(newName);
          if (rep >= 0) and (rep <> dest) then
            WriteLn('User already exists exist: ', newName)
          else begin
            uf.UserNames[dest] := newName;
            WriteLn('User renamed succesfully');
          end;
        end;
      end;
    end;

    uf.Free;
  except
    on e : Exception do
      WriteLn('Fatal error: ', e.Message);
  end;
end.
