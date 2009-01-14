unit FigureRotater;

interface

uses
  Figures;

{
  Вычисляет угол между векторами из точки center в точки p1 и p2
  Например, если center = (0; 0), p1 = (0; 1), p2 = (1; 0)
    функция вернет результат -pi/2
}
function angleBetween(const center, p1, p2 : TPoint) : Real;

{
  Поворачивает все фигуры из списка, хранимого модулем FigureList
    на угол angle относительно точки center

  Не забудьте записать изменения обратно в список
}
procedure rotateAllFigures(const center : TPoint; angle : Real);

implementation

function angleBetween(const center, p1, p2 : TPoint) : Real;
begin
  Result := 0;
end;

procedure rotateAllFigures(const center : TPoint; angle : Real);
begin

end;

end.
