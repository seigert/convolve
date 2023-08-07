package convolve

final case class Matrix(data: IArray[Double], height: Int, width: Int)

object Convolve:
  def naive(m: Matrix): Double =
    var res = 0.0
    var pos = 0

    for
      j <- 0 until m.height
      i <- 0 until m.width
    do
      var sum = 0.0;
      var div = 0;
      if i > 0 then
        sum += m.data(pos - 1)
        div += 1

      if j > 0 then
        sum += m.data(pos - m.width)
        div += 1

      if i < m.width - 1 then
        sum += m.data(pos + 1)
        div += 1

      if j < m.height - 1 then
        sum += m.data(pos + m.width)
        div += 1

      res += sum / div;
      pos += 1
    end for

    res
  end naive

  def segmented(m: Matrix): Double =
    var res = (m.data(1) + m.data(m.width)) / 2;

    for x <- 1 until (m.width - 1) do res += (m.data(x - 1) + m.data(x + 1) + m.data(x + m.width)) / 3

    res += (m.data(m.width - 2) + m.data(m.width)) / 2;

    var pos = m.width;
    for j <- 1 until (m.height - 1) do
      res += (m.data(pos + 1) + m.data(pos - m.width) + m.data(pos + m.width)) / 3
      pos += 1

      for i <- 1 until (m.width - 1) do
        res += (m.data(pos - 1) + m.data(pos - m.width) + m.data(pos + 1) + m.data(pos + m.width)) / 4
        pos += 1

      res += (m.data(pos - 1) + m.data(pos - m.width) + m.data(pos + m.width)) / 3
      pos += 1
    end for

    res += (m.data(pos + 1) + m.data(pos - m.width)) / 2
    pos += 1

    for x <- 1 until (m.width - 1) do
      res += (m.data(pos - 1) + m.data(pos + 1) + m.data(pos - m.width)) / 3
      pos += 1

    res += (m.data(pos - 1) + m.data(pos - m.width)) / 2

    res
  end segmented

  def logical(m: Matrix): Double =
    var res = 0.0
    var pos = 0

    for
      j <- 0 until m.height
      i <- 0 until m.width
    do
      val div1  = if i > 0 then 1 else 0;
      val div2  = if j > 0 then 1 else 0;
      val div3  = if i < m.width - 1 then 1 else 0;
      val div4  = if j < m.height - 1 then 1 else 0;
      val test1 = div1 * (pos - 1);
      val test2 = div2 * (pos - m.width);
      val test3 = div3 * (pos + 1);
      val test4 = div4 * (pos + m.width);

      res += (m.data(test1) * div1 + m.data(test2) * div2 + m.data(test3) * div3 + m.data(test4) * div4) / (div1 + div2 + div3 + div4);
      pos += 1;
    end for

    res
  end logical

end Convolve
