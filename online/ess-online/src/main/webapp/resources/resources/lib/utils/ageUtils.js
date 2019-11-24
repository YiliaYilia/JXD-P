function AgeUtils() {}
AgeUtils.prototype = {
	age : 0,
	ageInDay : 0,
	calculationAge : function(startDateStr, birthDateStr) {
		var startDate = new Date().parseDate(startDateStr);
		var birthDate = new Date().parseDate(birthDateStr); 
		if (startDate != null && birthDate != null) {
			var diffDays = dateDiffInDays(birthDate, startDate);
			this.ageInDay = diffDays;
			if (diffDays < 365) {
				this.age = 0;
			} else {
				var yearDiff = startDate.getFullYear() - birthDate.getFullYear();
				var monthDiff = startDate.getMonth() - birthDate.getMonth();
				var dayDiff = startDate.getDate() - birthDate.getDate();
				if (monthDiff < 0) {// ��������
					this.age = yearDiff - 1;
				} else if (monthDiff > 0) {// ��������
					this.age = yearDiff;
				} else {// Ҫ��day
					if (dayDiff < 0) {// ����
						this.age = yearDiff - 1;
					} else {// ����
						this.age = yearDiff;
					}
				}
			}
		}
	},
	
	getAge : function() {
		return this.age;
	},
	getAgeInDay : function () {
		return this.ageInDay;
	}
};