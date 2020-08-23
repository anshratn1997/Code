# require 'pry'
t = gets.chomp.to_i
t.times do
  n = gets.chomp.to_i
  arr = gets.chomp.split('')

  same = true
  (1...n).each do |i|
    if arr[i] != arr[i-1]
      same = false
      break
    end
  end
  if same
    puts((n + 2) / 3)
  else
    last_index = 0
    cnt = 1
    list = []
    (1...n).each do |i|
      if arr[i] == arr[last_index]
        cnt += 1
      else
        list << cnt
        last_index = i
        cnt = 1
      end
    end
    if arr[0] == arr[n - 1]
      list[0] = list[0].to_i + cnt
    else
      list << cnt
    end
    puts list.inject(0) { |sum, ele| sum + ele / 3 }
  end
end
