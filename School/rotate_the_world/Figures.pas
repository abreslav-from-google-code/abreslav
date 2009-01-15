unit Figures;

interface

type
  TPoint = packed record
    x, y : Real;
  end;

  TSegment = packed record
    a, b : TPoint;
  end;

  TCircle = packed record
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
