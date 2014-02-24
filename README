A very simple Play application demonstrating JsonP
===================================================

This very simple Play app is just meant to show how to return JsonP style responses.

The program accepts a callback either as passed in 'within' the URL path separators or as a traditional style parameter. 

The 'someNumber' argument will be taken from the URL and added to a 'someNumber' json tag. This along with some other sample JsValues will returned in a sample Json string with padding (JsonP) wrapped by the specified callback.


The routes file has 

```
GET     /jsonptestURL/:callback/:someNumber controllers.Application.getCallbackTest(someNumber:Int, callback: String)
GET     /jsonptestParam/:someNumber       	controllers.Application.getCallbackTest(someNumber:Int, callback: String)
```

to show the two ways of making the callback. 

The Application.scala controller processes the incoming params and returns the very simple Json object. 

There is intentionally no error trapping logic here, we just always assume the happy path and we return the JsonP as an 'Ok'


### Sample usage :

```
 $ curl -X GET -H Accept:application/json -H Content-Type:application/json http://localhost:9000/jsonptestParam/3000?callback=myTestCallback2
```
gives
```
myTestCallback2({"users":[{"name":"Bob","age":31,"email":"bob@gmail.com","someNumber":3000}]});
```

and 

```
curl -X GET -H Accept:application/json -H Content-Type:application/json http://localhost:9000/jsonptestURL/myTestCallback1/4000
```
gives
```
myTestCallback1({"users":[{"name":"Bob","age":31,"email":"bob@gmail.com","someNumber":4000}]});
```

