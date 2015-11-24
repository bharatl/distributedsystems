package com.madhukaraphatak.mesos.customexecutor

/**
 * Created by madhu on 1/10/14.
 */

/**
 * Task abstraction which can be sent over network
 * @tparam T return type of the task
 */

trait Task[T] extends Serializable{
  def run: T

}

/**
 * One of the implementation of Task which wraps the function
 * @param body function body
 * @tparam T return type of the task
 */
class  FunctionTask[T]( body: => () => T) extends Task[T] {
  override def run: T = body()
}
