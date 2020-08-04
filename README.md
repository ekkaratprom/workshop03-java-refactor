# workshop01-unit-test

### Circular buffer

#### 1. Data structure ? (Internal)
  * Array of String

#### 2. Operations/Behavior/Methods ? user -> CB ?
  * writeData(string):void
  * readData(): string
  * isFull(): boolean
  * isEmpty(): boolean
  * setSize(int): void

#### 3. Internal process ?

  * buffer size = 10 (default)
  * read pointer = 0
  * write pointer = 0
  * List of test cases
  * TC01 => create_new_buffer_should_empty
  * TC02 => create_new_buffer_with_default_size_should_10
  * TC03 => write_A_B_to_buffer_should_read_A_B
  * TC04 => write_until_full_and_write_Z_new_data_override_by_Z
  * TC05 => write_until_full_and_write_C_new_data_should_be_C_next_to_Z
  * TC06 => create_new_buffer_by_custom_size_6

#### 4. Refactoring : TennisGame2 
  * Long Method : getScore() The longer a method  is harder to understand and maintain it.
        * need to comment on something inside a method
        * have a code fragment that can be grouped together move this code to a separate new method (or function) 
        and replace the old code with a call to the method
        * make method has a descriptive name
    ref : https://sourcemaking.com/refactoring/extract-method