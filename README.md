# Fastu

Fastu is a small and fast UTF-8 encoder/decoder library for Java

It is in development, so I wouldn't use it in production yet.

## How fast is it?
Decoding UTF-8 bytes to Java String is around 35% faster comparing to the native String(byte[] data,String charset).

	Only ASCII chars
	******************************************
	502512 ops with native java.
	699300 ops with Fastu.
	
	Other UNICODE chars
	******************************************
	39729 ops with native java.
	47192 ops with Fastu.
 
## I want to contribute!

That is great! Just fork the project in github. Create a topic branch, write some tests and the feature that you wish to contribute.

Thanks for helping!

## License

Copyright (c) 2011 Jonathan Leibiusky

Permission is hereby granted, free of charge, to any person
obtaining a copy of this software and associated documentation
files (the "Software"), to deal in the Software without
restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following
conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.

