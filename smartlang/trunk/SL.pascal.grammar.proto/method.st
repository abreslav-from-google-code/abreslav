
public $m.returnType.simpleName$ $m.name$(IVisitHandler handler, $parameters; separator=", "$) {
	$m.returnType.simpleName$ result = $m.name$($arguments; separator=", "$);
	result.setVisitHandler(handler);
	return result;
}$\n$