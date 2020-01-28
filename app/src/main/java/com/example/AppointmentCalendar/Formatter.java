//package com.example.AppointmentCalendar;
//
//import android.content.Context;
//
//import org.jetbrains.annotations.NotNull;
//import org.joda.time.DateTime;
//import org.joda.time.DateTimeZone;
//import org.joda.time.LocalDate;
//import org.joda.time.format.DateTimeFormat;
//
//import kotlin.TypeCastException;
//import kotlin.jvm.internal.Intrinsics;
//
//public final class Formatter {
//    @NotNull
//    public static final String DAYCODE_PATTERN = "YYYYMMdd";
//    @NotNull
//    public static final String YEAR_PATTERN = "YYYY";
//    @NotNull
//    public static final String TIME_PATTERN = "HHmmss";
//    private static final String DAY_PATTERN = "d";
//    private static final String DAY_OF_WEEK_PATTERN = "EEE";
//    private static final String LONGEST_PATTERN = "MMMM d YYYY (EEEE)";
//    private static final String PATTERN_TIME_12 = "hh:mm a";
//    private static final String PATTERN_TIME_24 = "HH:mm";
//    private static final String PATTERN_HOURS_12 = "h a";
//    private static final String PATTERN_HOURS_24 = "HH";
//    public static final Formatter INSTANCE;
//
//    @NotNull
//    public final String getDateFromCode(@NotNull Context context, @NotNull String dayCode, boolean shortMonth) {
//        Intrinsics.checkParameterIsNotNull(context, "context");
//        Intrinsics.checkParameterIsNotNull(dayCode, "dayCode");
//        DateTime dateTime = this.getDateTimeFromCode(dayCode);
//        String day = dateTime.toString("d");
//        String year = dateTime.toString("YYYY");
//        byte var9 = 4;
//        byte var10 = 6;
//        boolean var11 = false;
//        String var10000 = dayCode.substring(var9, var10);
//        Intrinsics.checkExpressionValueIsNotNull(var10000, "(this as java.lang.Strin…ing(startIndex, endIndex)");
//        Integer monthIndex = Integer.valueOf(var10000);
//        Intrinsics.checkExpressionValueIsNotNull(monthIndex, "monthIndex");
//        String month = this.getMonthName(context, monthIndex);
//        if (shortMonth) {
//            Intrinsics.checkExpressionValueIsNotNull(month, "month");
//            var10 = 0;
//            int var14 = Math.min(month.length(), 3);
//            boolean var12 = false;
//            if (month == null) {
//                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
//            }
//
//            var10000 = month.substring(var10, var14);
//            Intrinsics.checkExpressionValueIsNotNull(var10000, "(this as java.lang.Strin…ing(startIndex, endIndex)");
//            month = var10000;
//        }
//
//        String date = month + ' ' + day;
//        if (Intrinsics.areEqual(year, (new DateTime()).toString("YYYY")) ^ true) {
//            date = date + ' ' + year;
//        }
//
//        return date;
//    }
//
//    // $FF: synthetic method
//    public static String getDateFromCode$default(Formatter var0, Context var1, String var2, boolean var3, int var4, Object var5) {
//        if ((var4 & 4) != 0) {
//            var3 = false;
//        }
//
//        return var0.getDateFromCode(var1, var2, var3);
//    }
//
//    @NotNull
//    public final String getDayTitle(@NotNull Context context, @NotNull String dayCode, boolean addDayOfWeek) {
//        Intrinsics.checkParameterIsNotNull(context, "context");
//        Intrinsics.checkParameterIsNotNull(dayCode, "dayCode");
//        String date = getDateFromCode$default(this, context, dayCode, false, 4, (Object)null);
//        DateTime dateTime = this.getDateTimeFromCode(dayCode);
//        String day = dateTime.toString("EEE");
//        return addDayOfWeek ? date + " (" + day + ')' : date;
//    }
//
//    // $FF: synthetic method
//    public static String getDayTitle$default(Formatter var0, Context var1, String var2, boolean var3, int var4, Object var5) {
//        if ((var4 & 4) != 0) {
//            var3 = true;
//        }
//
//        return var0.getDayTitle(var1, var2, var3);
//    }
//
//    public final String getLongestDate(long ts) {
//        return this.getDateTimeFromTS(ts).toString("MMMM d YYYY (EEEE)");
//    }
//
//    @NotNull
//    public final String getDate(@NotNull Context context, @NotNull DateTime dateTime, boolean addDayOfWeek) {
//        Intrinsics.checkParameterIsNotNull(context, "context");
//        Intrinsics.checkParameterIsNotNull(dateTime, "dateTime");
//        String var10002 = this.getDayCodeFromDateTime(dateTime);
//        Intrinsics.checkExpressionValueIsNotNull(var10002, "getDayCodeFromDateTime(dateTime)");
//        return this.getDayTitle(context, var10002, addDayOfWeek);
//    }
//
//    // $FF: synthetic method
//    public static String getDate$default(Formatter var0, Context var1, DateTime var2, boolean var3, int var4, Object var5) {
//        if ((var4 & 4) != 0) {
//            var3 = true;
//        }
//
//        return var0.getDate(var1, var2, var3);
//    }
//
//    @NotNull
//    public final String getFullDate(@NotNull Context context, @NotNull DateTime dateTime) {
//        Intrinsics.checkParameterIsNotNull(context, "context");
//        Intrinsics.checkParameterIsNotNull(dateTime, "dateTime");
//        String day = dateTime.toString("d");
//        String year = dateTime.toString("YYYY");
//        int monthIndex = dateTime.getMonthOfYear();
//        String month = this.getMonthName(context, monthIndex);
//        return month + ' ' + day + ' ' + year;
//    }
//
//    @NotNull
//    public final String getTodayCode() {
//        return this.getDayCodeFromTS(ConstantsKt.getNowSeconds());
//    }
//
//    public final String getHours(@NotNull Context context, @NotNull DateTime dateTime) {
//        Intrinsics.checkParameterIsNotNull(context, "context");
//        Intrinsics.checkParameterIsNotNull(dateTime, "dateTime");
//        return dateTime.toString(this.getHourPattern(context));
//    }
//
//    public final String getTime(@NotNull Context context, @NotNull DateTime dateTime) {
//        Intrinsics.checkParameterIsNotNull(context, "context");
//        Intrinsics.checkParameterIsNotNull(dateTime, "dateTime");
//        return dateTime.toString(this.getTimePattern(context));
//    }
//
//    public final DateTime getDateTimeFromCode(@NotNull String dayCode) {
//        Intrinsics.checkParameterIsNotNull(dayCode, "dayCode");
//        return DateTimeFormat.forPattern("YYYYMMdd").withZone(DateTimeZone.UTC).parseDateTime(dayCode);
//    }
//
//    public final DateTime getLocalDateTimeFromCode(@NotNull String dayCode) {
//        Intrinsics.checkParameterIsNotNull(dayCode, "dayCode");
//        return DateTimeFormat.forPattern("YYYYMMdd").withZone(DateTimeZone.getDefault()).parseLocalDate(dayCode).toDateTimeAtStartOfDay();
//    }
//
//    public final String getTimeFromTS(@NotNull Context context, long ts) {
//        Intrinsics.checkParameterIsNotNull(context, "context");
//        return this.getTime(context, this.getDateTimeFromTS(ts));
//    }
//
//    public final long getDayStartTS(@NotNull String dayCode) {
//        Intrinsics.checkParameterIsNotNull(dayCode, "dayCode");
//        DateTime var10000 = this.getLocalDateTimeFromCode(dayCode);
//        Intrinsics.checkExpressionValueIsNotNull(var10000, "getLocalDateTimeFromCode(dayCode)");
//        return DateTimeKt.seconds(var10000);
//    }
//
//    public final long getDayEndTS(@NotNull String dayCode) {
//        Intrinsics.checkParameterIsNotNull(dayCode, "dayCode");
//        DateTime var10000 = this.getLocalDateTimeFromCode(dayCode).plusDays(1).minusMinutes(1);
//        Intrinsics.checkExpressionValueIsNotNull(var10000, "getLocalDateTimeFromCode…usDays(1).minusMinutes(1)");
//        return DateTimeKt.seconds(var10000);
//    }
//
//    public final String getDayCodeFromDateTime(@NotNull DateTime dateTime) {
//        Intrinsics.checkParameterIsNotNull(dateTime, "dateTime");
//        return dateTime.toString("YYYYMMdd");
//    }
//
//    @NotNull
//    public final LocalDate getDateFromTS(long ts) {
//        return new LocalDate(ts * 1000L, DateTimeZone.getDefault());
//    }
//
//    @NotNull
//    public final DateTime getDateTimeFromTS(long ts) {
//        return new DateTime(ts * 1000L, DateTimeZone.getDefault());
//    }
//
//    @NotNull
//    public final DateTime getUTCDateTimeFromTS(long ts) {
//        return new DateTime(ts * 1000L, DateTimeZone.UTC);
//    }
//
//    public final String getMonthName(@NotNull Context context, int id) {
//        Intrinsics.checkParameterIsNotNull(context, "context");
//        return context.getResources().getStringArray(-200012)[id - 1];
//    }
//
//    @NotNull
//    public final String getHourPattern(@NotNull Context context) {
//        Intrinsics.checkParameterIsNotNull(context, "context");
//        return getConfig(context).getUse24HourFormat() ? "HH" : "h a";
//    }
//
//    @NotNull
//    public final String getTimePattern(@NotNull Context context) {
//        Intrinsics.checkParameterIsNotNull(context, "context");
//        return ContextKt.getConfig(context).getUse24HourFormat() ? "HH:mm" : "hh:mm a";
//    }
//
//    @NotNull
//    public final String getExportedTime(long ts) {
//        DateTime dateTime = new DateTime(ts, DateTimeZone.UTC);
//        return dateTime.toString("YYYYMMdd") + 'T' + dateTime.toString("HHmmss") + 'Z';
//    }
//
//    @NotNull
//    public final String getDayCodeFromTS(long ts) {
//        String daycode = this.getDateTimeFromTS(ts).toString("YYYYMMdd");
//        Intrinsics.checkExpressionValueIsNotNull(daycode, "daycode");
//        CharSequence var4 = (CharSequence)daycode;
//        boolean var5 = false;
//        return var4.length() > 0 ? daycode : "0";
//    }
//
////    public final long getShiftedImportTimestamp(long ts) {
////        DateTime var10000 = this.getUTCDateTimeFromTS(ts).withTime(13, 0, 0, 0).withZoneRetainFields(DateTimeZone.getDefault());
////        Intrinsics.checkExpressionValueIsNotNull(var10000, "getUTCDateTimeFromTS(ts)…ateTimeZone.getDefault())");
////        return DateTimeKt.seconds(var10000);
////    }
//
//    private Formatter() {
//    }
//
//    static {
//        Formatter var0 = new Formatter();
//        INSTANCE = var0;
//    }
//}
//
