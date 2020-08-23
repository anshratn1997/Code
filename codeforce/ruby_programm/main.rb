t = gets.chomp.to_i
t.times {
  n, k = gets.chomp.split(' ').map(&:to_i)
  arr = gets.chomp.split(' ').map(&:to_i)
  max = arr.max
  arr.map! { |ele| max - ele }
  max = arr.max
  if k % 2 == 0
    arr.map! { |ele| max - ele }
  end
  arr.each {|ele| print '%d ' % ele }
  print '\n'
}