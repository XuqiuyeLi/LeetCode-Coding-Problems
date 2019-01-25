private int kth(int[] a, int aleft, int[] b, int bleft, int k){
	// case cases
	if(aleft >= a.length){
		return b[bleft + k - 1];
	}
	if(bleft >= b.length){
		return a[aleft + k - 1];
	}
	if(k == 1){
		return Math.min(a[left], b[left]);
	}

	// sine index starts from left,
	// the k/2 th element shouls be left + k/2 - 1
	int amid = aleft + k / 2 - 1;
	int bmid = bleft + k / 2 - 1;

	// if a.size too small, then remove elements from b first
	int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
	int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];

	if(aval <= bval){
		return kth(a, amid + 1, b, bleft, k - k / 2);
	}
	else{
		return kth(a, aleft, b, bmid + 1, k - k / 2);
	}
}