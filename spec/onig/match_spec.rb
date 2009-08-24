require File.join(File.dirname(__FILE__), "..", "spec_helper.rb")

describe Onig::Match do
  before(:each) do
    rx = Onig::Rx.createRx("(f)(.)(o)")
    @match = rx.search(" foo ")
  end
  
  it "should not be nil" do
    @match.should_not be_nil
  end
  
  it "reports the number of captures" do
    @match.numCaptures.should == 4
  end
  
  it "reports the beginning and end of the match" do
    @match.begin(0).should == 1
    @match.end(0).should == 4
  end
  
  it "reports the beginning and end of the captures" do
    @match.begin(1).should == 1
    @match.end(1).should == 2
  end
end