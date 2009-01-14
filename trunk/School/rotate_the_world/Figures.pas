unit Figures;

interface

type
  TPoint = record
    x, y : Real;
  end;

  TSegment = record
    a, b : TPoint;
  end;

  TCircle = record
    center : TPoint;
    radius : Real;
  end;

const
  MAX_POLYGON_SIZE = 100;

type
  TPolygon = packed record
    size : Integer;
    points : array[1..MAX_POLYGON_SIZE] of TPoint;
  end;

  TFigureType = (ftError, ftSegment, ftCircle, ftPolygon);

implementation

end.
