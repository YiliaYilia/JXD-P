Array.prototype.remove = function(dx) {
	if(isNaN(dx)||dx>this.length){
		return false;
	}
	this.splice(dx,1);
};

/**
 * Returns <tt>true</tt> if this list contains the specified element.
 * More formally, returns <tt>true</tt> if and only if this list contains
 * at least one element <tt>e</tt> such that
 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
 *
 * @param o element whose presence in this list is to be tested
 * @return <tt>true</tt> if this list contains the specified element
 */
Array.prototype.contains = function(obj) {
	return this.get(obj) >= 0;
};

Array.prototype.notContain = function(obj) {
	return this.get(obj) == -1;
};
/**
 * Returns the index of the first occurrence of the specified element
 * in this list, or -1 if this list does not contain the element.
 * More formally, returns the lowest index <tt>i</tt> such that
 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
 * or -1 if there is no such index.
 */
Array.prototype.get = function(obj) {
	if (obj == null) {
	    for (var i = 0; i < this.lenght; i++) {
	    	if (this.i[i]==null) {
	    		return i;
	    	}
	    }
	} else {
	    for (var i = 0; i < this.length; i++) {
	    	if (obj == this[i]) {
				return i;
			}
	    }
	}
	return -1;
};