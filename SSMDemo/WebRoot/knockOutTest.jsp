<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/iscroll-probe.min.js"></script>
<script type="text/javascript" src="js/knockout-3.4.1.js"></script>
<script type="text/javascript">
			function AppViewModel() {
  var self = this;
  self.people = ko.observableArray([
    { name: 'Bert' },
    { name: 'Charles' },
    { name: 'Denise' }
  ]);
  self.addPerson = function() {
    self.people.push({ name: "New at " + new Date() });
  };
  self.removePerson = function() {
    self.people.remove(this);
  }
}
var myViewModel = new AppViewModel()
ko.applyBindings(myViewModel);
		</script>
</head>
<body>
<h4>People</h4>
<ul data-bind="foreach: people"> <!-- 在执行这条指令时，此处的绑定上下文是myViewModel，所以取myViewModel里的people这个值 -->
  <!-- 因为遇到了foreach指令，所以从这里开始，将进入新的绑定上下文，直至foreach绑定的标签ul结束，另外因为people的数组长度为3，所以要遍历生成三次才会结束  -->
  <li>
    Name at position <span data-bind="text: $index"> </span>:  <!-- foreach第一次遍历生成内部的这些节点时，$index为0，之后递增，$index是KO为绑定上下文内部添加的变量 -->
    <span data-bind="text: name"> </span> <!-- 第一次绑定上下文的name为Bert，其后分别为Charles、Denis -->
    <a href="#" data-bind="click: $parent.removePerson">Remove</a> <!-- $parent是KO内部为绑定上下文添加的变量，指向上一层的视图模型，此处即myViewModel -->
  </li>
  <!-- 遍历生成三次后结束 -->
</ul> <!-- 在此处之后，绑定上下文恢复为之前的myViewModel -->
<button data-bind="click: addPerson">Add</button> <!-- 从当前绑定上下文myViewModel中取得addPerson方法 -->
</body>
</html>