unit Utils;

interface

function CheckFileExtension(fileName : String) : Boolean;

implementation

uses
  SysUtils;

function CheckFileExtension(fileName : String) : Boolean;
var
  ext : String;
begin
  ext := ExtractFileExt(fileName);
  Result := (ext = '.pas') or (ext = '.dpr');
end;

end.
