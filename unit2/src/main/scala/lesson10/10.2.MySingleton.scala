package lesson10

// Listing 10.2
object MySingleton extends App {

  /** Java
    * public class MySingleton {
    * private static MySingleton instance = null;
    **
    *protected MySingleton() {}
    **
    *public static MySingleton getInstance() {
    * if(instance == null) {
    * instance = new ClassicSingleton();
    * }
    * return instance;
    * }
    * }
    * */

  /** JavaScript
    * var MySingleton = (function () {
    * var instance;
    **
    *function createInstance() {
    * var object = new Object("my-instance");
    * return object;
    * }
    **
    *return {
    * getInstance: function () {
    * if (!instance) {
    * instance = createInstance();
    * }
    * return instance;
    * }
    * };
    * })();
    * */

  object MySingleton

}
