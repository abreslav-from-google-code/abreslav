program findmcs;
{$APPTYPE CONSOLE}
uses
  SysUtils,
  Math,
  Classes,
  MCSUnit in 'MCSUnit.pas';

var
  a, b : TStream;
  aname, bname : String;
  adata, bdata : PBytes;
  asize, bsize : Integer;
  count : Integer;
begin
  if ParamCount < 2 then begin
    WriteLn('Finds maximum common subsequence of two byte files');
    WriteLn('Usage:');
    WriteLn('mcs <a.dat> <b.dat>');
    Exit;
  end;

  aname := ParamStr(1);
  bname := ParamStr(2);

  try
    a := TFileStream.Create(aname, fmOpenRead or fmShareDenyWrite);
    b := TFileStream.Create(bname, fmOpenRead or fmShareDenyWrite);

    asize := a.Size;
    bsize := b.Size;

    GetMem(adata, asize);
    count := a.Read(adata^, asize);
    Assert(count = asize);

    GetMem(bdata, bsize);
    count := b.Read(bdata^, bsize);
    Assert(count = bsize);

    a.Free;
    b.Free;

    count := mcs(adata, asize, bdata, bsize);
    WriteLn('MAX Common Suseq. : ', count, ' tokens');
    if asize > bsize then
      WriteLn(count / bsize * 100 :0:0, '% of ', bname)
    else WriteLn(count / asize * 100 :0:0, '% of ', aname);

    FreeMem(adata);
    FreeMem(bdata);
  except
    on e : Exception do
      WriteLn('Fatal error: ', e.Message);
  end;
end.
