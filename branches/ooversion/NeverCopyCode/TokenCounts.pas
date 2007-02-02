unit TokenCounts;

interface

uses
  AdvancedMetrics, Classes;

const
  TOKEN_COUNTS_EXTENSION = '.tc';

function GetTokenCountsFileName(sId : Integer) : String;
procedure countTokens(tokens : TStream; var tokenCounts : TTokenCounts);

implementation

uses
  DataCommons, PascalLexer, SysUtils;

function GetTokenCountsFileName(sId : Integer) : String;
begin
  Result := GetFileName(sId) + TOKEN_COUNTS_EXTENSION;
end;

procedure countTokens(tokens : TStream; var tokenCounts : TTokenCounts);
var
  t : TPascalToken;
begin
  FillChar(tokenCounts, sizeOf(tokenCounts), 0);

  while tokens.Read(t, sizeOf(t)) <> 0 do
    inc(tokenCounts[t]);
end;

end.
