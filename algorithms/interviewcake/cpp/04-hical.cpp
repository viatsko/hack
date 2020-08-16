#include <algorithm>
#include <iostream>
#include <vector>

// C++11 lest unit testing framework
#include "../vendor/lest.hpp"

class Meeting {
private:
  // number of 30 min blocks past 9:00 am
  unsigned int startTime_;
  unsigned int endTime_;

public:
  Meeting() : startTime_(0), endTime_(0) {}

  Meeting(unsigned int startTime, unsigned int endTime)
      : startTime_(startTime), endTime_(endTime) {}

  unsigned int getStartTime() const { return startTime_; }

  void setStartTime(unsigned int startTime) { startTime_ = startTime; }

  unsigned int getEndTime() const { return endTime_; }

  void setEndTime(unsigned int endTime) { endTime_ = endTime; }

  bool operator==(const Meeting &other) const {
    return startTime_ == other.startTime_ && endTime_ == other.endTime_;
  }
};

std::vector<Meeting> mergeRanges(const std::vector<Meeting> &meetings) {
  std::vector<Meeting> sortable(meetings);

  // merge meeting ranges
  std::vector<Meeting> result;

  std::sort(sortable.begin(), sortable.end(),
            [](const Meeting &lhs, const Meeting &rhs) {
              if (lhs.getStartTime() == rhs.getStartTime()) {
                return lhs.getStartTime() < rhs.getStartTime();
              }

              return lhs.getEndTime() < rhs.getEndTime();
            });

  std::vector<Meeting>::size_type n = sortable.size();
  for (std::vector<Meeting>::size_type i = 0; i < n; i++) {
    Meeting meeting = sortable[i];

    unsigned int start = meeting.getStartTime();
    unsigned int end = meeting.getEndTime();

    while ((i < (n - 1)) && (sortable[i + 1].getStartTime() <= end)) {
      end = sortable[i++ + 1].getEndTime();
    }

    result.push_back(Meeting(start, end));
  }

  return result;
}

const lest::test hicalTests[] = {
    CASE("(0, 1), (3, 5), (4, 8), (10, 12), (9, 10) = (0, 1), (3, 8), (9, 12)"){
      std::vector<Meeting> actual = mergeRanges(std::vector<Meeting>{Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)});
      std::vector<Meeting> expected = {Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)};
      EXPECT(actual == expected);
    },
    CASE("(1, 3), (2, 6), (8, 10), (15, 18) = (1, 6), (8, 10), (15, 18)"){
      std::vector<Meeting> actual = mergeRanges(std::vector<Meeting>{Meeting(1, 3), Meeting(2, 6), Meeting(8, 10), Meeting(15, 18)});
      std::vector<Meeting> expected = {Meeting(1, 6), Meeting(8, 10), Meeting(15, 18)};
      EXPECT(actual == expected);
    },
    CASE("(0, 1), (1, 2), (2, 3) = (0, 3)"){
      std::vector<Meeting> actual = mergeRanges(std::vector<Meeting>{Meeting(0, 1), Meeting(1, 2), Meeting(2, 3)});
      std::vector<Meeting> expected = {Meeting(0, 3)};
      EXPECT(actual == expected);
    },
    CASE("(0, 1), (0, 1), (1, 2), (2, 3) = (0, 3)"){
      std::vector<Meeting> actual = mergeRanges(std::vector<Meeting>{Meeting(0, 1), Meeting(0, 1), Meeting(1, 2), Meeting(2, 3)});
      std::vector<Meeting> expected = {Meeting(0, 3)};
      EXPECT(actual == expected);
    },
};

int main(int argc, char *argv[]) { return lest::run(hicalTests, argc, argv); }
