def asteroids(input)
  [].tap do |output|
    input.each do |current|
      if current < 0   # eat
        until output.empty?
          last = output.last

          output.pop if last.positive? && last <= current.abs
          current = nil if last >= current.abs
          break if last.negative? || current.nil?
        end
      end
      
      output << current unless current.nil?
    end
  end
end

cases = [
  [[], []],
  [[-1], [-1]],
  [[1], [1]],
  [[-1, -2], [-1, -2]],
  [[1, 2], [1, 2]],
  [[-1, 2], [-1, 2]],
  [[5, 10, -2], [5, 10]],
  [[8, -8], []],
  [[10, 2, -5], [10]],
  [[-2, -1, 1, 2], [-2, -1, 1, 2]],
  [[1, -2, -2, 1], [-2, -2, 1]]
]

cases.each do |input, expected|
  output = asteroids(input)
  puts "[ Input: #{input} | Output: #{output} | Expected: #{expected} | Result: #{expected == output ? 'PASS' : 'FAIL'} ]"
end
