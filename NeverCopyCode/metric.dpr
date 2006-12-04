program metric;
{$APPTYPE CONSOLE}

uses
  SysUtils,
  Math,
  Classes,
  MetricUnit in 'MetricUnit.pas';

var
  a, b : TStream;
  aname, bname : String;
  adata, bdata : PBytes;
  asize, bsize : Integer;
  mode : Boolean = false;
  count : Integer;
begin
  if ParamCount < 3 then begin
    WriteLn('Finds similarity metric of two byte files');
    WriteLn('Usage:');
    WriteLn('metric <-mcs|-ed> <a.dat> <b.dat>');
    WriteLn('Options:');
    WriteLn('  -mcs - maximum common subsequence');
    WriteLn('  -ed  - editing distance');
    Exit;
  end;

  if ParamStr(1) = '-ed' then
    mode := true
  else if ParamStr(1) = '-mcs' then
    mode := false
  else begin
    WriteLn('Unknown mode: ', ParamStr(1));
    Exit;
  end;
  
  aname := ParamStr(2);
  bname := ParamStr(3);

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

    WriteLn('Size of ', aname, ': ', asize, ' tokens');
    WriteLn('Size of ', bname, ': ', bsize, ' tokens');

    if mode then begin
      count := editingDistance(adata, asize, bdata, bsize);
      WriteLn('Editing Distance : ', count, ' tokens');
    end else begin
      count := mcs(adata, asize, bdata, bsize);
      WriteLn('MAX Common Suseq. : ', count, ' tokens');
    end;
    
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
